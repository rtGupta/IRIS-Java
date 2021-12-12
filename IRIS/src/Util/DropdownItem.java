/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Business.UserAccount.UserAccount;

/**
 *
 * @author aarti
 */
public class DropdownItem {

    private String key;
    private UserAccount value;

    public DropdownItem(String key, UserAccount value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key; 
    }

    public UserAccount getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key;
    }
}
