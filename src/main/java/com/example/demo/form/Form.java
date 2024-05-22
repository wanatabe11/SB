package com.example.demo.form;

import jakarta.validation.constraints.Size;

public class Form {
	//HTMLファイルのname属性の値と一致させる
	@Size(min=1, max=10, message="1～10文字以内にしてください")
	
	private String name1;
	private int age1;

	//コンストラクター
	public Form() {
	}

	//ゲッター
	public String getName1() {
		return name1;
	}
	public int getAge1() {
		return age1;
	}

	//セッター
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public void setAge1(int age1) {
		this.age1 = age1;
		
		
	}
}
