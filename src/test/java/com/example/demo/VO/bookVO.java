package com.example.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookVO {
	private int id;
	private String title;
	private String author;
	private int storeId;
}
