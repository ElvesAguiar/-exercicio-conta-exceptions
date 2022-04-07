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

	@Override
	public void deposit(double amount) {

		setBalance(getBalance() + amount);
	}

	@Override
	public void withdraw(double amount) {

		if (super.getBalance() == 0) {
			throw new DomainException("Balance must be different than zero!!");

		} else {
			if (super.getBalance() < amount) {
				throw new DomainException("Balance must greater than amount!!");
			} else {
				super.setBalance(getBalance() - amount);
			}
		}
	}

}
