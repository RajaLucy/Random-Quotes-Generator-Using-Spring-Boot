package in.ashokit.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.Repository.CitiesRepository;
import in.ashokit.Repository.CountryRepository;
import in.ashokit.Repository.StateRepository;
import in.ashokit.entity.Cities;
import in.ashokit.entity.Countries;
import in.ashokit.entity.States;


@Component
public class DataLoader  implements ApplicationRunner{

	
    	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CitiesRepository cityRepo;
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		countryRepo.deleteAll();
		stateRepo.deleteAll();
		cityRepo.deleteAll();
		
		Countries c1=new Countries(1,"India");
		Countries c2=new Countries(2,"USA");
		countryRepo.saveAll(Arrays.asList(c1,c2));
		
		
		States s1=new States(1,"AP",1);
		States s2=new States(2,"TS",1);
		
		States s3=new States(3,"US1",2);
		States s4=new States(4,"US2",2);
		
		
		stateRepo.saveAll(Arrays.asList(s1,s2,s3,s4));
		
		
		Cities p1=new Cities(1,"Nlr",1);
		Cities p2=new Cities(2,"Gun",1);
		
		Cities p3=new Cities(3,"Hyd",2);
		Cities p4=new Cities(4,"KHm",2);
		
		Cities p5=new Cities(5,"Js1",3);
		Cities p6=new Cities(6,"Js2",3);
		
		Cities p7=new Cities(7,"kir",4);
		Cities p8=new Cities(8,"Kir2",4);
		
		cityRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
		
		
		
		
		
		
		
	}

}
