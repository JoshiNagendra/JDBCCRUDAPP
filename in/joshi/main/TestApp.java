package in.joshi.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.joshi.controller.IStudentController;
import in.joshi.dto.Student;
import in.joshi.factory.StudentControllerFactory;


public class TestApp {
	static IStudentController stdController;
	

	public static void main(String[] args) {
		String name = null;
		String city=null;
		String email=null;
		String country=null;
		String status = null;
		Student student=null;
		Student studentRecord=null;
		Integer sid;

		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("Your Option [1,2,3,4,5,6] ::");

				Integer option = Integer.parseInt(br.readLine());

				switch (option) {
				case 1:
					stdController = StudentControllerFactory.getStudentController();
					student = new Student();
					System.out.println("Welcome to CREATE operation");
					System.out.println();
					System.out.println("Enter the name    ::");
					 name = br.readLine();
					System.out.println("Enter the city    ::");
					 city = br.readLine();
					System.out.println("Enter the email   ::");
					 email = br.readLine();
					System.out.println("Enter the country ::");
					 country = br.readLine();
					student.setName(name);
					student.setCity(city);
					student.setEmail(email);
					student.setCountry(country);
					status = stdController.save(student);
					if (status.equalsIgnoreCase("sucess")) {
						System.out.println("Record Inserted Sucessfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record Insertion is failed..");

					} else {
						System.out.println("Something Went Wrong..");
					}

					break;
				case 2:
					stdController=StudentControllerFactory.getStudentController();
					System.out.println("Enter the ID ::");
					sid=Integer.parseInt(br.readLine());
					student =new Student();
					
					studentRecord = stdController.findById(sid);
					if(studentRecord !=null) {
					System.out.println("Test Results   ::"+studentRecord);
					}else {
						System.out.println("Record Not Found");
					}
					
					break;
				case 3:
					System.out.println("Enter the id");
					sid = Integer.parseInt(br.readLine());
					stdController=StudentControllerFactory.getStudentController();
                    
					studentRecord = stdController.findById(sid);
					if(studentRecord !=null) {
                       
						Student newStudent = new Student();
						newStudent.setSid(sid);
						System.out.println("Old Name is ::"+studentRecord.getName());
						String newName =br.readLine();
						if(newName==null || newName.equalsIgnoreCase("")) {
							newStudent.setName(studentRecord.getName());
						}else {
							newStudent.setName(newName);
						}
						System.out.println("Old city is ::"+studentRecord.getCity());
						String newCity=br.readLine();
						if(newCity==null || newCity.equalsIgnoreCase("")) {
							newStudent.setCity(studentRecord.getCity());
						}else {
							newStudent.setCity(newCity);
						}
						System.out.println("Old Email is ::"+studentRecord.getEmail());
						String newEmail=br.readLine();
						if(newEmail==null || newEmail.equalsIgnoreCase("")) {
							newStudent.setEmail(studentRecord.getEmail());
						}else {
							newStudent.setEmail(newEmail);
						}
						System.out.println("Old Country is ::"+studentRecord.getCountry());
						String newCountry=br.readLine();
						if(newCountry == null || newCountry.equalsIgnoreCase("")) {
							newStudent.setCountry(studentRecord.getCountry());
						}else {
							newStudent.setCountry(newCountry);
						}
						status =stdController.updateById(newStudent);
						
						
					}else {
						status="notavail";
					}
					
					if(status.equalsIgnoreCase("sucess")) {
						System.out.println("UpdatedSucessfully");
					}else if(status.equalsIgnoreCase("failure")) {
						System.out.println("Failed");
					}else {
						System.out.println("Not found");
					}
					

					break;
				case 4:
					stdController=StudentControllerFactory.getStudentController();
					System.out.println("Enter the ID ::");
					sid=Integer.parseInt(br.readLine());
					
					status = stdController.deleteById(sid);
					if(status.equalsIgnoreCase("sucess")) {
						System.out.println("Record Deleted Sucessfully");
					}else if(status.equalsIgnoreCase("failure")) {
						System.out.println("Record Deletion Failed ");
					}else {
						System.out.println("Record Not available");
					}
					break;
				case 5:
					System.out.println("Thank you for using this application");
					System.exit(0);
				case 6:
					System.out.println("Please Select Valid OPtion");
					break;

				}

			}
		} catch (Exception e) {
			
		}
		stdController = StudentControllerFactory.getStudentController();
		System.out.println(stdController.getClass().getName());

	}

}
