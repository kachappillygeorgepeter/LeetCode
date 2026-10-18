/*                                  WRONGGGGGGGGGGGG
class Solution
{
    public int maxProfit(int[] prices)
    {
        int pos=0, min_cost=prices[0];
        for(int i=1; i<prices.length; i++)
            if(prices[i]<min_cost)
            {
                min_cost=prices[i];
                pos=i;
            }
        int profit=0;
        for(int i=pos; i<prices.length; i++)
            if((prices[i]-min_cost)>profit)
                profit=prices[i]-min_cost;
        return profit;
    }
}*/

/*
1.Track the minimum stock price seen so far.
2.Calculate the profit if you sell at the current price.
3.Update the maximum profit.*/
class Solution
{
    public int maxProfit(int[] prices)
    {
        int min_price=Integer.MAX_VALUE, max_profit=0;
        for (int i=0; i<prices.length; i++)
        {
            if (prices[i]<min_price)
                min_price=prices[i];
            else
                max_profit=Math.max(max_profit, prices[i]-min_price);
        }
        return max_profit;
    }
}
