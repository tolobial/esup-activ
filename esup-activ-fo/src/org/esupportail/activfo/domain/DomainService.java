/**
 * ESUP-Portail esup-activ-fo - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-activ-fo
 */
package org.esupportail.activfo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.esupportail.activfo.domain.beans.Account;
import org.esupportail.activfo.domain.beans.User;
import org.esupportail.activfo.exceptions.KerberosException;
import org.esupportail.activfo.exceptions.LdapProblemException;
import org.esupportail.activfo.exceptions.UserPermissionException;
import org.esupportail.commons.exceptions.ConfigException;
import org.esupportail.commons.exceptions.UserNotFoundException;
import org.esupportail.commons.services.application.Version;
import org.esupportail.commons.services.ldap.LdapException;
import org.esupportail.commons.web.beans.Paginator;

/**
 * The domain service interface.
 */
public interface DomainService extends Serializable {

	//////////////////////////////////////////////////////////////
	// User
	//////////////////////////////////////////////////////////////

	/**
	 * @param id
	 * @return the User instance that corresponds to an id.
	 * @throws UserNotFoundException
	 */
	User getUser(String id) throws UserNotFoundException;

	/**
	 * @return the list of all the users.
	 */
	List<User> getUsers();

	/**
	 * Update a user.
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * Update a user's information (retrieved from the LDAP directory for instance).
	 * @param user
	 */
	void updateUserInfo(User user);
	
	/**
	 * Add an administrator.
	 * @param user
	 */
	void addAdmin(User user);

	/**
	 * Delete an administrator.
	 * @param user
	 */
	void deleteAdmin(User user);

	/**
	 * @return a paginator for administrators.
	 */
	Paginator<User> getAdminPaginator();

	//////////////////////////////////////////////////////////////
	// VersionManager
	//////////////////////////////////////////////////////////////
	
	/**
	 * @return the database version.
	 * @throws ConfigException when the database is not initialized
	 */
	Version getDatabaseVersion() throws ConfigException;
	
	/**
	 * Set the database version.
	 * @param version 
	 */
	void setDatabaseVersion(Version version);
	
	/**
	 * Set the database version.
	 * @param version 
	 */
	void setDatabaseVersion(String version);
	
	//////////////////////////////////////////////////////////////
	// Authorizations
	//////////////////////////////////////////////////////////////

	/**
	 * @param currentUser
	 * @return 'true' if the user can view administrators.
	 */
	boolean userCanViewAdmins(User currentUser);
	
	/**
	 * @param user 
	 * @return 'true' if the user can grant the privileges of administrator.
	 */
	boolean userCanAddAdmin(User user);

	/**
	 * @param user 
	 * @param admin
	 * @return 'true' if the user can revoke the privileges of an administrator.
	 */
	boolean userCanDeleteAdmin(User user, User admin);
	
	public HashMap<String,String> validateAccount(HashMap<String,String> hashInfToValidate,List<String>attrPersoInfo) throws LdapProblemException;
	
	public boolean setPassword(String id,String code,final String currentPassword)throws LdapProblemException,UserPermissionException,KerberosException;
	
	public HashMap<String,String> setPassword(String id,String oldPassword,final String currentPassword,List<String>attrPersoInfo)throws LdapProblemException,UserPermissionException,KerberosException;
	
	public boolean updatePersonalInformations(String id,String code,HashMap<String,String> hashBeanPersoInfo)throws LdapProblemException,UserPermissionException;
	
	public String getCode(String id,String canal);
	
	public String getCode(String id);
	
	public boolean validateCode(String id,String code);
	
	//public void updateDisplayName(String displayName,String id, String code);
	
	//public void setMailPerso(String id,String mailPerso);
	
//	public int validateCode(String id,String code);
	
	
	

}	
