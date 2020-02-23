package com.meloche.ticketsorter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class main {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
    
    private static List<Ticket> sortNum(List<Ticket> tickets)
    {
        tickets.sort(Comparator.comparing(Ticket::getNum));
        
        return tickets;
    }
    
    private static List<Ticket> sortCode(List<Ticket> tickets)
    {
        tickets.sort(Comparator.comparing(Ticket::getCode));
        
        return tickets;
    }

    private static List<Ticket> sortDays(List<Ticket> tickets)
    {
        tickets.sort(Comparator.comparing(Ticket::getDays));
        
        return tickets;
    }
    
    private static List<Ticket> sortPrice(List<Ticket> tickets)
    {
        tickets.sort(Comparator.comparing(Ticket::getPrice));
        
        return tickets;
    }
    
    private static List<Ticket> sortType(List<Ticket> tickets)
    {
        tickets.sort(Comparator.comparing(Ticket::getType));
        
        return tickets;
    }
    
    private static List<Ticket> sortDate(List<Ticket> tickets)
    {
        tickets.sort(Comparator.comparing(Ticket::getDate));
        
        return tickets;
    }
    
    private static void createOutput(List<Ticket> tickets)
    {
        StringBuilder sb = new StringBuilder();
        
        for (Ticket ticket : tickets)
        {
            sb.append(String.valueOf(ticket.getNum()) + ',');
            sb.append(ticket.getCode() + ',');
            sb.append(String.valueOf(ticket.getDays()) + ',');
            sb.append(String.valueOf(ticket.getPrice()) + ',');
            sb.append(ticket.getType() + ',');
            sb.append(dateFormat.format(ticket.getDate()) + '\n');
        }
        
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws ParseException {

        BufferedReader br = null;
        String line = "";
        List<Ticket> tickets = null;
        Ticket ticket = null;

        try {

            br = new BufferedReader(new FileReader("Tickets.csv"));
            tickets = new ArrayList();
            boolean isFirst = true;

            while ((line = br.readLine()) != null)
            {
                if (isFirst)
                {
                    isFirst = false;
                    continue;
                }
                
                if (line == "")
                {
                    return;
                }
                
                ticket = new Ticket();

                String[] fields = line.split(",");

                ticket.setNum(Integer.parseInt(fields[0]));
                ticket.setCode(fields[1]);
                ticket.setDays(Integer.parseInt(fields[2]));
                ticket.setPrice(Integer.parseInt(fields[3]));
                ticket.setType(fields[4]);
                ticket.setDate(dateFormat.parse(fields[5]));

                tickets.add(ticket);
            }

            switch (args[0])
            {
                case "num":
                    tickets = sortNum(tickets);
                    break;
                
                case "code":
                    tickets = sortCode(tickets);
                    break;

                case "days":
                    tickets = sortDays(tickets);
                    break;
                
                case "price":
                    tickets = sortPrice(tickets);
                    break;

                case "type":
                    tickets = sortType(tickets);
                    break;
                
                case "date":
                    tickets = sortDate(tickets);
                    break;
                
                default:
                    System.out.println("Invalid argument: " + args[0] + "\n");
                    return;
            }
            
            createOutput(tickets);

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

}