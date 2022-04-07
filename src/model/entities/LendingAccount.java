package model.entities;

import model.exceptions.DomainException;

public class LendingAccount extends Account {
	private Double withdrawLimit;

	public LendingAccount() {

	}

	public LendingAccount(Integer number, String holder, Double balance, Double withdrawLimit) {
		super(number, holder, balance);
		this.withdrawLimit = withdrawLimit;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	private void validateWithdraw(double amount) {
		if (super.getBalance() == 0) {
			throw new DomainException("Balance must be different than zero to make withdraw!!");

		}

		if (amount > withdrawLimit) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new DomainException("Withdraw error: Not enough balance");
		}
	}

	@Override
	public void deposit(double amount) {

		setBalance(getBalance() + amount);
	}

	@Override
	public void withdraw(double amount) {
		validateWithdraw(amount);

		super.setBalance(getBalance() - amount);

	}

}
