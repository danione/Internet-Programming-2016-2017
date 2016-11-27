package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Filter {

	@ApiModelProperty(value = "What the user entered", example = "Ap", required = true)
	private String filter;
	@ApiModelProperty(value = "If developer was selected", example = "true", required = true)
	private boolean developer;
	@ApiModelProperty(value = "If model was selected", example = "false", required = true)
	private boolean model;
	@ApiModelProperty(value = "If storage was selected", example = "false", required = true)
	private boolean storage;
	@ApiModelProperty(value = "If price was selected", example = "false", required = true)
	private boolean price;
	@ApiModelProperty(value = "The lower border of storage", example = "0", required = true)
	private int lowerStorage;
	@ApiModelProperty(value = "The higher border of storage", example = "0", required = true)
	private int higherStorage;
	@ApiModelProperty(value = "The lower border of price", example = "0.0", required = true)
	private double lowerPrice;
	@ApiModelProperty(value = "The higher border of price", example = "0.0", required = true)
	private double higherPrice;
	
	public Filter(String filter, boolean developer, boolean model, boolean storage, boolean price, int lowerStorage,
			int higherStorage, double lowerPrice, double higherPrice) {
		super();
		this.filter = filter;
		this.developer = developer;
		this.model = model;
		this.storage = storage;
		this.price = price;
		this.lowerStorage = lowerStorage;
		this.higherStorage = higherStorage;
		this.lowerPrice = lowerPrice;
		this.higherPrice = higherPrice;
	}

	public Filter()
	{
		
	}
	
	public boolean isPrice() {
		return price;
	}
	public void setPrice(boolean price) {
		this.price = price;
	}
	public boolean isStorage() {
		return storage;
	}
	public void setStorage(boolean storage) {
		this.storage = storage;
	}
	public boolean isModel() {
		return model;
	}
	public void setModel(boolean model) {
		this.model = model;
	}
	public boolean isDeveloper() {
		return developer;
	}
	public void setDeveloper(boolean developer) {
		this.developer = developer;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public double getHigherPrice() {
		return higherPrice;
	}
	public void setHigherPrice(double higherPrice) {
		this.higherPrice = higherPrice;
	}
	public double getLowerPrice() {
		return lowerPrice;
	}
	public void setLowerPrice(double lowerPrice) {
		this.lowerPrice = lowerPrice;
	}

	public int getHigherStorage() {
		return higherStorage;
	}

	public void setHigherStorage(int higherStorage) {
		this.higherStorage = higherStorage;
	}

	public int getLowerStorage() {
		return lowerStorage;
	}

	public void setLowerStorage(int lowerStorage) {
		this.lowerStorage = lowerStorage;
	}
}
