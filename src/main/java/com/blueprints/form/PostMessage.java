package com.blueprints.form;

import java.util.Date;

public class PostMessage {

    private String subject;
    private Date datePosted;
    private String postedMsg;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Date getDatePosted() {
        return datePosted;
    }
    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
    public String getPostedMsg() {
        return postedMsg;
    }
    public void setPostedMsg(String postedMsg) {
        this.postedMsg = postedMsg;
    }

    @Override
    public String toString() {
        return "PostMessage{" +
                "subject='" + subject + '\'' +
                ", datePosted=" + datePosted +
                ", postedMsg='" + postedMsg + '\'' +
                '}';
    }
}
