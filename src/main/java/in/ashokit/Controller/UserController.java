package in.ashokit.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.RegisterForm;
import in.ashokit.binding.ResetPwdForm;
import in.ashokit.entity.User;
import in.ashokit.service.DashBoardServiceImp;
import in.ashokit.service.UserServiceImp;

@Controller
public class UserController {

	@Autowired
	private UserServiceImp userSer;

	@Autowired
	private DashBoardServiceImp dashSer;

	// load the login form

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("login", new LoginForm());
		return "login";
	}

	@GetMapping("/register")
	public String registerLoad(Model model) {
	    model.addAttribute("regi", new RegisterForm());
	    Map<Integer, String> countries = userSer.getCountries();
	    if (countries != null) {
	        model.addAttribute("countries", countries);
	    } else {
	        model.addAttribute("countries", new HashMap<Integer, String>());
	    }
	    return "register";
	}

	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStates(@RequestParam("counId") Integer counId) {
		return userSer.getStates(counId);
	}

	@GetMapping("/getCities")
	@ResponseBody
	public Map<Integer, String> getCities(@RequestParam("stateId") Integer stateId)
	{
		return userSer.getCities(stateId);
	}

	@GetMapping("/reset")
	public String resetPwd(Model model) {
		model.addAttribute("regi", new ResetPwdForm());
		return "register";
	}

	@PostMapping("/loginchek")
	public String loginChek(Model model, @ModelAttribute("login") LoginForm l) {
		User login = userSer.login(l);

		if (login == null) {
			model.addAttribute("err", "Invalid Sir");
			return "login";
		}
		if (login.getPassUpdate().equals("NO")) {
			ResetPwdForm pwdForm = new ResetPwdForm();
			pwdForm.setUserId(login.getUserId());
			model.addAttribute("pwd", pwdForm);
			return "resetPwd";
		}

		return "redirect:dashboard";
	}

	@PostMapping("/reset")
	public String resetPwd(Model model, @ModelAttribute("pwd") ResetPwdForm r) {
		
		if(!r.getNewPass().equals(r.getConFromPass()))
		{
			model.addAttribute("msg", "Not matched");
			return "resetPwd";
		}
		
		
		boolean pwd = userSer.resetPwd(r);
		

		if (pwd) {
			return "dashboard";
		}
		return "resetPwd";

	}

	@GetMapping("/dashboard")
    public String getDash(Model model) {
		String quote = dashSer.getQuote();

		model.addAttribute("quote", quote);
		return "dashboard";

	}

	@PostMapping("/register")
	public String regi(Model model, @ModelAttribute("regi") RegisterForm re) {

		User user = userSer.getUser(re.getUserMail());
		if (user != null) {

			model.addAttribute("msg", "already exits");
			return "register";

		}

		boolean b = userSer.saveUser(re);
		if (b) {

			model.addAttribute("msg", "saved success");
		} else {
			model.addAttribute("msg", "Failed");
		}

		Map<Integer, String> countries = userSer.getCountries();
		model.addAttribute("countries", countries);

		return "register";

	}

}
