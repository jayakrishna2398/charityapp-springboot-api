package com.revature.charityapp.model;

public class Email {
private String to;
private String text;
private String subject;
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
@Override
public String toString() {
	return "Email [to=" + to + ", text=" + text + ", subject=" + subject + "]";
}


}
