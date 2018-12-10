package com.in28minutes.rest.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("/demo")
public class TopicController 
{
	@Autowired
	private TopicService topicserv;
	
	@Bean	
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.in28minutes.rest.restfulwebservices"))              
          .paths(PathSelectors.any())                          
          .build();                                           
	}
	
    @RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicserv.getAllTopics();
	}
    
    @RequestMapping("/topics/{id}")
	public Topic getTopics(@PathVariable String id)
	{
    	
		return topicserv.getTopic(id);
	}
    
    @RequestMapping(method=RequestMethod.POST,value="/topics") 
    public void addTopic(@RequestBody Topic topic)
    {
    	topicserv.addTopic(topic);    }
    
    
    @RequestMapping(method=RequestMethod.PUT,value="/topics/{id}") 
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
    {
    	topicserv.updateTopic(topic,id);    }
    
    @RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void getDelete(@PathVariable String id)
	{
    	
	 topicserv.getDelete(id);
	}
    
    
    
}
