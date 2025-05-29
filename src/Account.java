public abstract class Account {
    protected long balance;

    public Account(long initialBalance) {
        this.balance = initialBalance;
    }

    // Метод для пополнения счета
    public boolean add(long amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Метод для списания средств
    public boolean pay(long amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Метод для перевода средств
    public boolean transfer(Account targetAccount, long amount) {
        if (this.pay(amount)) {
            return targetAccount.add(amount);
        }
        return false;
    }

    // Метод для получения текущего баланса
    public long getBalance() {
        return balance;
    }
}