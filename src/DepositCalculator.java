import java.util.Scanner;

public class DepositCalculator {
    static final double YEAR_RATE = 0.06;
    static final int NUMBER_OF_PLACES = 2;

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

    void calculateDeposit() {
        int period;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях: ");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах: ");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией: ");
        action = scanner.nextInt();

        double profit = 0;
        if (action == 1) {
            profit = calculateSimplePercent(amount, YEAR_RATE, period);
        } else if (action == 2) {
            profit = calculateComplexPercent(amount, YEAR_RATE, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + profit);
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, NUMBER_OF_PLACES);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount + amount * yearRate * depositPeriod;
        return round(pay, NUMBER_OF_PLACES);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
