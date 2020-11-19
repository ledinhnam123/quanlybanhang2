package quanlybanhang.DTO;

import quanlybanhang.Entity.CategoryEntity;

public class CategoryDTO {

	private int id;

	private String name;

	public CategoryDTO() {


	}
	public CategoryDTO(CategoryEntity category) {
		this.id = category.getId();
		this.name = category.getCategoryName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
