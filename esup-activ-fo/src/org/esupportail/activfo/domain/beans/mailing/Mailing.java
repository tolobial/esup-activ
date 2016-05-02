/**
 * interface d'envoi de mail pour signaler des modifications de données personnelles nécessitant une validation
 */
package org.esupportail.activfo.domain.beans.mailing;

import org.esupportail.activfo.domain.beans.Account;
import java.util.List;
import java.util.Map;
/**
 * @author aanli
 *
 */
public interface Mailing {

	public void sendMessage(Account currentAccount, Map<String,List<String>> oldValue, Map<String,List<String>> newValue);
	public boolean isAllowed(Account currentAccount);
		
		
}
