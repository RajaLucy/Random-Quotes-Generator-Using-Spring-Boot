package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.ashokit.Repository.CitiesRepository;
import in.ashokit.Repository.CountryRepository;
import in.ashokit.Repository.StateRepository;
import in.ashokit.Repository.UserRepository;
import in.ashokit.Utils.EmailUtils;
import in.ashokit.binding.LoginForm;
import in.ashokit.binding.RegisterForm;
import in.ashokit.binding.ResetPwdForm;
import in.ashokit.entity.Cities;
import in.ashokit.entity.Countries;
import in.ashokit.entity.States;
import in.ashokit.entity.User;

@Service
public class UserServiceImp implements UserService{

    @Autowired	
	private CountryRepository countryRepo;
	
    @Autowired
    private StateRepository stateRepo;
    
    @Autowired
    public CitiesRepository citiRepo;
    
    @Autowired
    public UserRepository userRepo;
	
   
    
    @Autowired
    private EmailUtils emailUtils;
    
	Random re=new Random();

	
	@Override
	public Map<Integer, String> getCountries() {
	    List<Countries> all = countryRepo.findAll();
	    Map<Integer, String> mylist = new HashMap<>();
	    all.forEach(e -> mylist.put(e.getCounId(), e.getCountryName()));
	    return mylist;
	}


	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		
		List<States> list = stateRepo.findByCounId(countryId);
		Map<Integer, String> mylist=new HashMap<Integer, String>();
		
		list.forEach(i ->{
			mylist.put(i.getStateId(), i.getStateName());
		});
		
		
		return mylist;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {

		List<Cities> list = citiRepo.findByStateId(stateId);
		Map<Integer, String> mylist=new HashMap<Integer, String>();
		list.forEach(i ->{
			mylist.put(i.getCityId(), i.getCityName());
		});
		
		return mylist;
	}

	//to check mail available availbale or not
	
	@Override
	public User getUser(String email) {
		
		 
		return userRepo.findByUserMail(email);
	}

	@Override
	public boolean saveUser(RegisterForm formObj) {
     
		User userObj = new User();
		BeanUtils.copyProperties(formObj, userObj);
		userObj.setPassUpdate("NO");
		
		
		
		String s="abcdefghij";
		StringBuffer st=new StringBuffer();
		for(int i=0;i<4;i++)
		{
			int j = re.nextInt(s.length()-1);
			st.append(s.charAt(j));
			
		}
		
		
		userObj.setUserPwd(st.toString());
	
		userRepo.save(userObj);
		
		String to=formObj.getUserMail();
		String sub="Your Password";
		String text="Password is :"+userObj.getUserPwd();
		
		return emailUtils.sendEmail(sub, text, to);
       
		
		
		 
	}

	@Override
	public User login(LoginForm formObj)
	{
		
		User user = userRepo.findByUserMailAndUserPwd(formObj.getEmail(), formObj.getPassword());
		
		
		return user;
	}

	@Override
	public boolean resetPwd(ResetPwdForm formObj) {
	
		
		Optional<User> id = userRepo.findById(formObj.getUserId());
		if(id.isPresent())
		{
			User user = id.get();
			user.setUserPwd(formObj.getNewPass());
			user.setPassUpdate("YES");
			userRepo.save(user);
			return true;
			
			
		}
		
	    
		
		
		return false;
	}

	
	
	
	
	
	
	

}
