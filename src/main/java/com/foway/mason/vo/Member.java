package com.foway.mason.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@Column(name = "member_serial_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberserialnumber;
	@Column(name = "member_account")
	private String memberaccount;
	@Column(name = "member_password")
	private String memberpassword;
	@Column(name = "member_name")
	private String membername;
	@Column(name = "member_birthday")
	private Date memberbirthday;
	@Column(name = "member_address")
	private String memberaddress;
	@Column(name = "member_email")
	private String memberemail;
	@Column(name = "member_phone_number")
	private String memberphonenumber;
	@Column(name = "member_status")
	private Integer memberstatus;
	@Column(name = "gold_remaining")
	private Integer goldremaining;
	@Column(name = "member_evaluate_quantity")
	private Integer memberevaluatequantity;
	@Column(name = "member_evaluate_stars")
	private Integer memberevaluatestars;
	@Override
	public String toString() {
		return "MemberHibernate [memberserialnumber=" + memberserialnumber + ", memberaccount=" + memberaccount
				+ ", memberpassword=" + memberpassword + ", membername=" + membername + ", memberbirthday="
				+ memberbirthday + ", memberaddress=" + memberaddress + ", memberemail=" + memberemail
				+ ", memberphonenumber=" + memberphonenumber + ", memberstatus=" + memberstatus + ", goldremaining="
				+ goldremaining + ", memberevaluatequantity=" + memberevaluatequantity + ", memberevaluatestars="
				+ memberevaluatestars + "]";
	}
	public Member() {

	}
	public Member(Integer memberserialnumber, String memberaccount, String memberpassword, String membername,
			Date memberbirthday, String memberaddress, String memberemail, String memberphonenumber,
			Integer memberstatus, Integer goldremaining, Integer memberevaluatequantity, Integer memberevaluatestars) {
		super();
		this.memberserialnumber = memberserialnumber;
		this.memberaccount = memberaccount;
		this.memberpassword = memberpassword;
		this.membername = membername;
		this.memberbirthday = memberbirthday;
		this.memberaddress = memberaddress;
		this.memberemail = memberemail;
		this.memberphonenumber = memberphonenumber;
		this.memberstatus = memberstatus;
		this.goldremaining = goldremaining;
		this.memberevaluatequantity = memberevaluatequantity;
		this.memberevaluatestars = memberevaluatestars;
	}

	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}
	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}
	public String getMemberaccount() {
		return memberaccount;
	}
	public void setMemberaccount(String memberaccount) {
		this.memberaccount = memberaccount;
	}
	public String getMemberpassword() {
		return memberpassword;
	}
	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public Date getMemberbirthday() {
		return memberbirthday;
	}
	public void setMemberbirthday(Date memberbirthday) {
		this.memberbirthday = memberbirthday;
	}
	public String getMemberaddress() {
		return memberaddress;
	}
	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	public String getMemberemail() {
		return memberemail;
	}
	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	public String getMemberphonenumber() {
		return memberphonenumber;
	}
	public void setMemberphonenumber(String memberphonenumber) {
		this.memberphonenumber = memberphonenumber;
	}
	public Integer getMemberstatus() {
		return memberstatus;
	}
	public void setMemberstatus(Integer memberstatus) {
		this.memberstatus = memberstatus;
	}
	public Integer getGoldremaining() {
		return goldremaining;
	}
	public void setGoldremaining(Integer goldremaining) {
		this.goldremaining = goldremaining;
	}
	public Integer getMemberevaluatequantity() {
		return memberevaluatequantity;
	}
	public void setMemberevaluatequantity(Integer memberevaluatequantity) {
		this.memberevaluatequantity = memberevaluatequantity;
	}
	public Integer getMemberevaluatestars() {
		return memberevaluatestars;
	}
	public void setMemberevaluatestars(Integer memberevaluatestars) {
		this.memberevaluatestars = memberevaluatestars;
	}
	

}
