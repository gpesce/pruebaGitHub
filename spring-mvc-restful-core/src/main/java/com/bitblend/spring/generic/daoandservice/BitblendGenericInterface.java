package com.bitblend.spring.generic.daoandservice;

import java.util.List;

/**
 * This is a generic interface might be used for extend DAO and SERVICE layer. Both layers are pretty similar 
 * but the purpose of them are actually very different.
 * The idea is, put here the similarities in order to keep it simple and avoid code repetition.
 * 
 * DAO and SERVICE layers differences:
 * Generally the DAO is as light as possible and exists solely to provide a connection to the DB, 
 * sometimes abstracted so different DB back-ends can be used.
 * 
 * The service layer is there to provide logic to operate on the data sent to and from the DAO and the client. 
 * Very often these 2 pieces will be bundled together into the same module, and occasionally into the same code, 
 * but you'll still see them as distinct logical entities.
 * Another reason is security - If you provide a service layer that has no relation to the DB, then is it more difficult to 
 * gain access to the DB from the client except through the service. 
 * If the DB cannot be accessed directly from the client (and there is no trivial DAO module acting as the service) then all 
 * an attacker who has taken over the client can do is attempt to hack the service layer as well before he gets all but the 
 * most sanitized access to your data.
 * 
 */
public interface BitblendGenericInterface<T> {

   long save(T type);

   T get(long id);

   List<T> list();

   void update(long id, T type);

   void delete(long id);

}
