package com.curd.curddemo;

import javax.ws.rs.Path;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path ("student")
public class Studentresource 
{
	Studentresource repo = new Studentresource();
	
	@GET  
	  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Student> getStudent()
	{
		return repo.getStudent();
	}
	
  @GET	
  @Path("student/{id}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Student getStudent(@PathParam("id") int id)
  {
	  return repo.getStudent(id);	
  }
  
  @POST
  @Path("student")
  public Student createStudent(Student s1)
  {
	  System.out.println(s1);
	  repo.createStudent(s1);
	  
	  return s1;
  }
	
  @PUT
  @Path("student")
  @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
  public Student updateStudent(Student s1)
  {
	  System.out.println(s1);
	  if(repo.getStudent(s1.getId()).getId()==0)
	  {
	  repo.createStudent(s1);
	  }
	  else
	  {
		 repo.updateStudent(s1);

	  }
	  return s1;
  }

  
  @DELETE
  @Path("student/{id}")
  public Student KillStudent(@PathParam("id") int id)
  {
	  Student s = repo.getStudent(id);
	  
	  if(s.getId()!=0)
	  {
		  repo.delete(id);
	  }
	return s;
  }

private void delete(int id) {
	// TODO Auto-generated method stub
	
}

}

