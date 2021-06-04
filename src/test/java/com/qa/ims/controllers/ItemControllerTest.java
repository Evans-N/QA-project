package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;
	
	@Test 
	public void testCreate() {
		Item item = new Item("jacket", 35d);
		
		Mockito.when(this.utils.getString()).thenReturn("jacket");
		Mockito.when(this.utils.getDouble()).thenReturn(35d);
		Mockito.when(this.dao.create(item)).thenReturn(item);
		
		assertEquals(item, controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		
		items.add(new Item(1L, "apple", 1d));
		
		Mockito.when(dao.readAll()).thenReturn(items);
		
		assertEquals(items, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "frisbee", 10d);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getValue());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	
	@Test 
	public void testInvalidId() {
		List<Item> items = new ArrayList<Item>();
		Item item = new Item(1L, "lego", 15d);
		items.add(item);
		
		Mockito.when(this.dao.readAll()).thenReturn(items);
		Mockito.when(this.utils.getLong()).thenReturn(2L);
		Mockito.when(this.dao.read(2L)).thenReturn(null);
		
		assertEquals(null, this.controller.update());
		
		Mockito.verify(this.dao, Mockito.times(1)).readAll();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).read(2L);
	}
	
	@Test public void testDelete() {
		final Long id = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(dao.delete(1)).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(id);
	}
}
