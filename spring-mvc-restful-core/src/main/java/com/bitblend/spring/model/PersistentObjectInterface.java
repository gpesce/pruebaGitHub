package com.bitblend.spring.model;


import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @author Gaston Pesce
 * 
 * The interface PersistentObject specifies the behavior for all persistent objects.
 * 
 * A JavaBean is just a standard:
 * 1. All properties private (use getters/setters)
 * 2. A public no-argument constructor
 * 3. Implements Serializable -> And thats the meaning of this interface
 * 
 * That's it. It's just a convention. Lots of libraries depend on it though.
 * With respect to Serializable, from the API documentation:
 * Serializability of a class is enabled by the class implementing the java.io.Serializable interface. 
 * Classes that do not implement this interface will not have any of their state serialized or deserialized. 
 * All subtypes of a serializable class are themselves serializable. The serialization interface has no methods or fields and serves 
 * only to identify the semantics of being serializable.
 * 
 * In other words, Serializable objects can be written to streams, and hence files, object databases, anything really.
 * Also, there is no syntactic difference between a JavaBean and another class -- a class is a JavaBean if it follows the standards.
 * There is a term for it because the standard allows libraries to programmatically do things with class instances you define in a 
 * predefined way. For example, if a library wants to stream any object you pass into it, it knows it can because your object is 
 * serializable (assuming the lib requires your objects be proper JavaBeans).
 * 
 */
public interface PersistentObjectInterface extends Serializable {

    public Long getId();
    public void setId(Long id);   	

    public Long getVersion();
    public void setVersion(Long version);
    
   	public Timestamp getCreationTimestamp();
   	public void setCreationTimestamp(Timestamp newCreationTimestamp);
    	
   	public Timestamp getModificationTimestamp();
    public void setModificationTimestamp(Timestamp newModificationTimestamp);    	
    	
   	public String getCreationUserId();
   	public void setCreationUserId(String userId);
   	
	public String getCreationIPAddress();
	public void setCreationIPAddress(String newIPAddress);  	   	

	public String getModificationUserId();
	public void setModificationUserId(String userId);

	public String getModificationIPAddress();
	public void setModificationIPAddress(String newIPAddress);
}
