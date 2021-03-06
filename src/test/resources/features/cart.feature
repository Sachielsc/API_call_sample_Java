@web
Feature: Verify Items on the cart and price

	@cart
	Scenario: Verify the items on the cart and price
		Given a customer adds following items to the cart
			| Copacetic Capybara   | 5 |
			| Cheerful Capybara    | 2 |
			| Forlorn Capybara     | 3 |
		Then sub total should be correct for all items
		And total price of items should be correct