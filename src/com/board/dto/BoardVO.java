package com.board.dto;

//sql에 해당하는거로 import...
import java.sql.Timestamp;

//import com.sun.jmx.snmp.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


// @Data
@Getter
@Setter
@ToString
@Data 
public class BoardVO {
	private int num;
	private String name;
	private String pass;
	private String email;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
}
