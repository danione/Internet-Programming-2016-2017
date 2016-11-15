package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Phone {
	
	@ApiModelProperty(required = true)
	private int id;
	@ApiModelProperty(value = "This will show the developer of the phone", example = "Samsung", required = true)
	private String developer;
	@ApiModelProperty(value = "This will show the model of the phone", example = "S6 Edge Plus", required = true)
	private String model;
	@ApiModelProperty(value = "This will show the storage of the phone in GB", example = "32", required = true)
	private int storage;
	@ApiModelProperty(value = "This will show the price of the phone in dollars", example = "400.99", required = true)
	private double price;
	
	public Phone()
	{
		this.id = 0;
		this.developer = null;
		this.model = null;
		this.storage = 0;
		this.price = 0.0;
	}

	public Phone(int id, String developer, String model, int storage, double price) {
		super();
		this.id = id;
		this.developer = developer;
		this.model = model;
		this.storage = storage;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setName(String developer) {
		this.developer = developer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

}
