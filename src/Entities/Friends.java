/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author rymlarayedh
 */
public class Friends {

    private int userid;
    private int friendid;

    public Friends() {

    }

    public Friends(int userid, int friendid) {
        this.userid = userid;
        this.friendid = friendid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getFriendid() {
        return friendid;
    }

    public void setFriendid(int friendid) {
        this.friendid = friendid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Friends other = (Friends) obj;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.friendid != other.friendid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Friends{" + "userid=" + userid + ", friendid=" + friendid + '}';
    }

}
