import java.util.Scanner;
public class Retirement {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter how many years will you work: ");
		int work_years = input.nextInt();
		
		System.out.println("Enter average annual return while investing (0-20%): ");
		double investment_return = input.nextDouble() / 100;
		while (investment_return < 0 || investment_return > 0.2) {
			System.out.println("Average annual return while investing must be between 0% and 20%. Enter a new value: ");
			investment_return = input.nextDouble() / 100;
		}
		
		System.out.println("Enter expected number of years in retirement: ");
		int retire_years = input.nextInt();
		
		System.out.println("Enter average annual return while retired (0-3%): ");
		double payback_return = input.nextDouble() / 100;
		while (payback_return < 0 || payback_return > 0.03) {
			System.out.println("Average annual return while retired must be between 0% and 3%. Enter a new value: ");
			payback_return = input.nextDouble() / 100;
		}
		
		System.out.println("Enter required monthly income while retired: ");
		double required_income = input.nextDouble();
		
		System.out.println("Enter expected monthly SSI income: ");
		double SSI = input.nextDouble();
		
		// Calculate total savings at the end of investment mode.
		double total_savings = (12 / payback_return) * (required_income - SSI) * (1 - Math.pow(1 + payback_return / 12, -(retire_years * 12)));
		
		// Calculate required monthly savings during investment mode.
		double monthly_savings = (investment_return / 12) * total_savings / (Math.pow(1 + investment_return / 12, work_years * 12) - 1);
		
		System.out.println("You must save $" + Math.round(monthly_savings * 100.0) / 100.0 + " per month.");

	}

}
