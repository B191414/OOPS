package audit;

interface TaxAuditor 
{
    void taxChecker(double totalIncome, double taxPaid, double homeExpenditure, double healthExpenditure,
                    double vehicleExpenditure, double personalFamilyExpenditure, double miscellaneousExpenditure) throws TaxFraudException;

    double taxPaid(double totalIncome, double expenditures);

    double homeExpenditure(double totalIncome, double homeExpenditure);

    double healthExpenditure(double totalIncome, double healthExpenditure);

    double vehicleExpenditure(double totalIncome, double vehicleExpenditure);

    double personalFamilyExpenditure(double totalIncome, double personalFamilyExpenditure);

    double miscellaneousExpenditure(double totalIncome, double miscellaneousExpenditure);
}

class TaxFraudException extends Exception 
{
    public TaxFraudException(String message)
     {
        super(message);
     }
}

public class TaxFraudDetection implements TaxAuditor
 {
    @Override
    public void taxChecker(double totalIncome, double taxPaid, double homeExpenditure, double healthExpenditure,double vehicleExpenditure, double personalFamilyExpenditure, double miscellaneousExpenditure)
     throws TaxFraudException 
      {

        double totalExpenditure = homeExpenditure + healthExpenditure + vehicleExpenditure
                + personalFamilyExpenditure + miscellaneousExpenditure;

        double calculatedTax = totalIncome - totalExpenditure;
        double expectedTax = 0.1 * calculatedTax;

        if (taxPaid != expectedTax) 
        {
            throw new TaxFraudException("Tax fraud detected! You need to pay $" + expectedTax);
        }
         else 
         {
            System.out.println("Tax payment is valid.");
         }
    }

    @Override
    public double taxPaid(double totalIncome, double expenditures)
     {
        return 0.1 * (totalIncome - expenditures);
    }

    @Override
    public double homeExpenditure(double totalIncome, double homeExpenditure) 
    {
        return 0.1 * (totalIncome - homeExpenditure);
    }

    @Override
    public double healthExpenditure(double totalIncome, double healthExpenditure)
     {
        return 0.1 * (totalIncome - healthExpenditure);
    }

    @Override
    public double vehicleExpenditure(double totalIncome, double vehicleExpenditure) 
    {
        return 0.1 * (totalIncome - vehicleExpenditure);
    }

    @Override
    public double personalFamilyExpenditure(double totalIncome, double personalFamilyExpenditure) 
    {
        return 0.1 * (totalIncome - personalFamilyExpenditure);
    }

    @Override
    public double miscellaneousExpenditure(double totalIncome, double miscellaneousExpenditure)
     {
        return 0.1 * (totalIncome - miscellaneousExpenditure);
    }

    public static void main(String[] args) 
    {
        TaxFraudDetection taxAuditor = new TaxFraudDetection();

        try {
            // Simulating user inputs
            double totalIncome = 50000;
            double taxPaid = 4500;
            double homeExpenditure = 10000;
            double healthExpenditure = 5000;
            double vehicleExpenditure = 2000;
            double personalFamilyExpenditure = 3000;
            double miscellaneousExpenditure = 1000;

            taxAuditor.taxChecker(totalIncome, taxPaid, homeExpenditure, healthExpenditure,
                    vehicleExpenditure, personalFamilyExpenditure, miscellaneousExpenditure);

        } 
        catch (TaxFraudException e) 
        {
            System.out.println("Tax Fraud Exception: " + e.getMessage());
        }
    }
}

