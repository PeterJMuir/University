public class ReceiptListTester
{
	public static void main(String [] args)
	{
		StockList	stocks = new StockList();
		ReceiptList receipt = new ReceiptList();

		stocks.addToFront(new Item("apple", 1.00, "1111"));
		stocks.addToFront(new Item("banana", 2.00, "2222"));
		stocks.addToFront(new Item("pear", 3.00, "3333"));
		stocks.addToFront(new Item("orange", 4.00, "4444"));
		System.out.println("Stocks:");
		stocks.display();
		System.out.println();

		Item item = stocks.find("2222");	// scan "2222"
		receipt.scan(item);
		System.out.println("Receipt:");
		receipt.display();
		System.out.println();

		item = stocks.find("3333");		// scan "3333"
		receipt.scan(item);
		System.out.println("Receipt:");
		receipt.display();
		System.out.println();

		item = stocks.find("3333");		// scan "3333"
		receipt.scan(item);
		System.out.println("Receipt:");
		receipt.display();
		System.out.println();

		receipt.writeReceipt();
	}
}