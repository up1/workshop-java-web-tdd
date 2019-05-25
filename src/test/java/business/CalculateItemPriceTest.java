package business;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculateItemPriceTest {

    @Test
    public void ซื้อ_starwar_dart_vader_lego_ราคา__3995_จำนวน_2_ชิ้น_ต้องได้ยอดรวม_7990() {
        // Arrange
        Product starwar = new Product("starwar_dart_vader_lego", 39.95, 2);
        Order order = new Order();
        order.addProduct(starwar);

        // Act
        double actualTotalPrice = order.calculateTotalPrice();

        // Assert
        double expectedTotalPrice = 79.90;
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

}
