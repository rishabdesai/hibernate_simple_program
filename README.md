# hibernate basic code

[click here](https://drishabh.wordpress.com/2020/07/09/advance-java-hibernate/)

### hibernate_basic_withoutDAO
- connect to database using Hibernate without using DAO layer
- using get() method, you can get only one record of given primary key 
- get()
	- Find the record by given primary key and return the entity object. Eager execution.


### hibernate_basic_Insert_Update_Delete
- perform basic CRUD operations (INSERT, SELECT, UPDATE, DELETE ) using DAO layer

### Load_evict_update_persist_merge
- perform CRUD operations using methods of Hibernate Session class
- load(), evict(), update(), persist(), merge() 
- load()
	- same as get() method. Lazy execution
	- It returns proxy of entity object. When proxy object is accessed, actual SELECT query is fired.
	- improves performance.
	- if record don't exists - ObjectNotFoundException
	- LazyInitializationException - if you access the object after closing the session.
- persist()
	- execute INSERT query on database
	- must be called within transaction. The INSERT query will execute during commit operation
	- It is JAP compliant
	-returns void
- update()
	- Add object into session cache with dirty flag set to true
	- UPDATE query is executed on such object while transaction commit.
- merge()
	- Add object into session cache
	- execute SELECT query to check if object exists(by primary key).
	- if object exists, update query fired, otherwise insert query is fired.
	- JPA compliant
	
### XML_based_mapping
- Hibernate 3 added annotation for ORM
- earlier versions does ORM using  .hbm.xml file

### openSession_and_getCurrentSession
- difference between openSession() and getCurrentSession()

### hibernate5_bootstrapping
- steps
	- Create ServiceRegistry (interface - use to add, manage hibernate services/functionality)
	- Create Metadata (ORM part - use for ORM mapping information) 
	- Create SessionFactory

###	SQL_HQL_queries
- SQL query
- HQL query

### primary_key
- user of @GeneratedValue, Strategy=GenerationType.IDENTITY, AUTO, TABLE, SEQUENCE
- @Embaddable, @EmbeddedId

### OneToMany 

### ManyToOne

### OneToOne

### ManyToMany

### Inheritance

### SP_NamedNativeQuery
- @NamedNativeQuery 
- using Stored Procedure

### SP_OUT_parameter

### JPA

### Forward Engineering
- POJO first (First create entity class and then auto-create RDBMS tables)
	
	


-