package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SaleTest {
	
	
	SoldItem item1 = new SoldItem(new StockItem((long) 10, "Tester1", "ForTestingPurposes", 10.7, 25), 10); 
	SoldItem item2 = new SoldItem(new StockItem((long) 11, "Tester2", "ForTestingPurposesEtc", 2.5, 86), 14); 
	SoldItem item3 = new SoldItem(new StockItem((long) 12, "Tester3", "ForTestingPurposesEtc.Etc.", 0.1, 600), 460); 
	SoldItem[] saleAr = {};
	SoldItem[] saleAr2 = {item1};
	SoldItem[] saleAr3 = {item1, item2, item3};

	Order order1 = new Order((long)20, Arrays.asList(saleAr));
	Order order2 = new Order((long)21, Arrays.asList(saleAr2));
	Order order3 = new Order((long)22, Arrays.asList(saleAr3));
	Order order4 = new Order((long)23, Arrays.asList(saleAr2));

	@Test
	public void testAddSoldItem(){
		double sumWithoutAddedItem = order4.calculateTotalSum();
		ArrayList<SoldItem> items = new ArrayList(order4.getSoldItems());
		items.add(item2);
		Order testOrder = new Order((long)24,items);
		assertEquals(testOrder.calculateTotalSum(), sumWithoutAddedItem + item2.getSum(), 0.0001);
		//kuna Orderil ei ole addItem meetodit, siis tegin uue orderi
	}
	@Test
	public void testGetSumWithNoItems(){
		assertEquals(order1.calculateTotalSum(), 0, 0.0001);
	}
	@Test
	public void testGetSumWithOneItem(){
		assertEquals(order2.calculateTotalSum(), 107, 0.0001);
	}
	@Test
	public void testGetSumWithMultipleItems(){
		assertEquals(order3.calculateTotalSum(), 188, 0.0001);
	}
}
