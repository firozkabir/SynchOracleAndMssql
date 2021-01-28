package ca.yorku.sis.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaWorker {

	private static final EntityManagerFactory ORACLE_ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Oracle");
	private static final EntityManagerFactory MSSQL_ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Mssql");



	public static void createStudentOracle( int id, String name, int age  ){
		
		
        EntityManager manager = ORACLE_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            StudentOracle stu = new StudentOracle();
            stu.setId(id);
            stu.setName(name);
            stu.setAge(age);

            // Save the student object
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
    
            
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
		
		
	} // end of createStudentOracle()
	
	
	/**
     * Read all the Students.
     * 
     * @return a List of Students
     */
    public static List readAllOracle() {

        List students = null;

        // Create an EntityManager
        EntityManager manager = ORACLE_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            students = manager.createQuery("SELECT s FROM StudentOracle s",
                    StudentOracle.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    } // end of readAllOracle() 
    
    
    
    
    public static void upateOracle(int id, String name, int age) {
        // Create an EntityManager
        EntityManager manager = ORACLE_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            StudentOracle stu = manager.find(StudentOracle.class, id);

            // Change the values
            stu.setName(name);
            stu.setAge(age);

            // Update the student
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    
    
    } // end of upateOracle()
	
    
    
    /**
     * Delete the existing Student.
     * 
     * @param id
     */
    public static void deleteOracle(int id) {
        // Create an EntityManager
        EntityManager manager = ORACLE_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            StudentOracle stu = manager.find(StudentOracle.class, id);

            // Delete the student
            manager.remove(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    
    
    }  // deleteOracle()
    
    
    
    public static void demoOracle() {
    	
    	
    	List list = JpaWorker.readAllOracle();
    	
    	for (int i = 0; i < list.size() ; i++) {
    		
    		
    		System.out.println(list.get(i).toString());
    		
    		
    	}
    	
    	
    } // end of demoOracle()
	

    

    
    
	public static void createStudentMssql( int id, String name, int age  ){
		
		
        EntityManager manager = MSSQL_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            StudentMssql stu = new StudentMssql();
            stu.setId(id);
            stu.setName(name);
            stu.setAge(age);

            // Save the student object
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
    
            
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
		
		
	} // end of createStudentMssql()
	
	
	/**
     * Read all the Students.
     * 
     * @return a List of Students
     */
    public static List readAllMssql() {

        List students = null;

        // Create an EntityManager
        
        
        
        EntityManager manager = MSSQL_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
        	
        
        	
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            students = manager.createQuery("SELECT s FROM StudentMssql s",
                    StudentMssql.class).getResultList();
            
            
          

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    } // end of readAllOracle() 
    
    
    public static void upateMssql(int id, String name, int age) {
        // Create an EntityManager
        EntityManager manager = MSSQL_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            StudentMssql stu = manager.find(StudentMssql.class, id);

            // Change the values
            stu.setName(name);
            stu.setAge(age);
            	
                                 

            // Update the student
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    
    
    } // end of upateMssql()
	
    
    
    /**
     * Delete the existing Student.
     * 
     * @param id
     */
    public static void deleteMssql(int id) {
        // Create an EntityManager
        EntityManager manager = MSSQL_ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Student object
            StudentMssql stu = manager.find(StudentMssql.class, id);

            // Delete the student
            manager.remove(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    
    
    }  // deleteMssql()
    
    
    
    
    
    public static void demoMssql() {
    	
    	System.out.println(" Step 01: showing you before state of Mssql table");
    	
    	List mssqlListBefore = JpaWorker.readAllMssql();
    	for (int i = 0; i < mssqlListBefore.size() ; i++)
    	{
    		System.out.println("mssql data: " +  mssqlListBefore.get(i).toString());
    		
    	}
    	
    	System.out.println(" Step 02: showing you current state of Oracle table");
    	
    	
    	List oracleList = JpaWorker.readAllOracle();
    	
    	for (int i = 0; i < oracleList.size() ; i++) {
    		
    		System.out.println("oracle data: " + oracleList.get(i).toString());
    	
    		
    	}
    	
    	System.out.println(" Step 03: updating Mssql table with Oracle data ");
    	
    	
    	for (int i = 0; i < oracleList.size() ; i++) {
    		
    		   		
    		System.out.println("oracle data: " + oracleList.get(i).toString());
    		
    		StudentOracle o = (StudentOracle) oracleList.get(i);
    		
    		    		
    		JpaWorker.upateMssql(o.getId(), o.getName(), o.getAge());
    			
    		   		
    		
    	
    		
    	}
    	
    	
        System.out.println(" Step 04: showing you after state of Mssql table");
    	
    	List mssqlListAfter = JpaWorker.readAllMssql();
    	for (int i = 0; i < mssqlListAfter.size() ; i++)
    	{
    		System.out.println("mssql data: " +  mssqlListAfter.get(i).toString());
    		
    	}
    	
    	
    	
    	
    	
    	
    } // end of demoMssql()    
    
    
    
    
    
    
    


}



