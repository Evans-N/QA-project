//package com.qa.ims.persistence.domain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Order {
//	
//	private Long id;
//	private Long customerId;
//	private List<Item> items;
//	private Double total;
//	private Integer quantity;
//	
//	public Order(Long customerId, List<Item> items) {
//		this.setCustomerId(customerId);
//		this.items = items;
//		this.quantity = items.size();
//		this.total = total;
//	}
//	
//	public Order(Long id, Long customerId, List<Item> items) {
//		this.setOrderId(id);
//		this.setCustomerId(customerId);  
//	}
//	
//	public Long getOrderId() {
//		return id;
//	}
//
//	public void setOrderId(Long id) {
//		this.id = id;
//	}
//	
//	public Long getCustomerId() {
//		return customerId;
//	}
//	
//	public void setCustomerId(Long customerId) {
//		this.customerId = customerId;
//	}
//	
//	public List<Item> getItems() {
//		return items;
//	}
//	
//	public void setItem(List<Item> items) {
//		this.items = items;
//	}
//	
//	public void addItems(Item item, Integer quantity) {
//		for (int i = 0; i < quantity; i++) {
//			this.items.add(item);
//		}
//	}
//	
//	public int getQuantity(Item target) {
//		int quantity = 0;
//		for (Item item : this.items) {
//			if(item.getItemId() == target.getItemId()) {
//				quantity +=1;
//			}
//		}
//		return quantity;
//	}
//	
//	public Double getTotal() {
//		return this.total;
//	}
//	
//	
//	@Override
//	public String toString() {
//		return "id:" + id + "customerId:" + customerId + "items:" + items;
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((items == null) ? 0 : items.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Order other = (Order) obj;
//		if (getCustomerId() == null) {
//			if (other.getCustomerId() != null)
//				return false;
//		} else if (!getCustomerId().equals(other.getCustomerId()))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (items == null) {
//			if (other.items != null)
//				return false;
//		} else if (!items.equals(other.items))
//			return false;
//		return true;
//	}
//
//}
