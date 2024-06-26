package org.approvaltests.koans.lesson02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.approvaltests.Approvals;
import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.koans.helpers.Sequence;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;
import org.lambda.functions.Function1;

/**
 * How to do Koans:
 * Step 1: Press the Run Button (Place cursor on the Method name to run a single method)
 * PC: Ctrl+F11
 * Mac: Command+fn+F11
 * Step 2: Read the name of the Method that Failed
 * Step 3: Fill in the blank (___) to make it pass
 * Step 4: Repeat Until Enlightenment
 * Do not change anything except the blank (___)
 */
@UseReporter(JunitReporter.class)
public class Collections extends Koans
{
  @Test
  public void simpleArrays() throws Exception
  {
    String[] approvalsIsPortedTo = {".Net", "Java", "Perl", "Ruby", "Php", "Node.js"};
    Approvals.verifyAll("Language", approvalsIsPortedTo);
  }

  @Test
  public void listsWorkTheSameAsArrays() throws Exception
  {
    List<String> approvalsIsGoodFor = new ArrayList<String>();
    approvalsIsGoodFor.add("Strings");
    approvalsIsGoodFor.add("Objects");
    approvalsIsGoodFor.add("Log Files");
    approvalsIsGoodFor.add("JPanels");
    approvalsIsGoodFor.add("Collections");
    approvalsIsGoodFor.add("Xml");
    approvalsIsGoodFor.add("Html");
    approvalsIsGoodFor.add("Json");
    approvalsIsGoodFor.add("Email");
    Approvals.verifyAll("Good For", approvalsIsGoodFor);
  }

  @Test
  public void mapsAreSortedBeforeDisplay() throws Exception
  {
    HashMap<Integer, String> m = new HashMap<Integer, String>();
    m.put(1000, "M");
    m.put(10, "X");
    m.put(1, "I");
    m.put(100, "C");
    m.put(5, "V");
    m.put(500, "D");
    m.put(50, "L");
    Approvals.verify(m);
  }

  @Test
  public void theUseOfTheLabel() throws Exception
  {
    String[] greatTv = {
      "Firefly",
      "Game of Thrones",
      "Futurama",
      "Arrested Development",
      "Big Bang Theory",
      "Better Off Ted"
    };
    Approvals.verifyAll("TV Show", greatTv);
  }

  @Test
  public void approvalHelpShowWhenThingsHaveBeenRemoved() throws Exception
  {
    HashMap<String, String> m = new HashMap<String, String>();
    m.put("Miss Scarlet", "Conservatory");
    m.put("Colonel Mustard", "Kitchen");
    m.put("Mrs. White", "Billiard Room");
    m.put("Mr. Green", "Library");
    m.put("Mrs. Peacock", "Dining Room");
    m.put("Professor Plum", "Study");
    m.remove("Mr. Green");
    Approvals.verify(m);
  }

  @Test
  public void approvalHelpShowWhenThingsHaveBeenAdded() throws Exception
  {
    HashMap<String, String> punch = new HashMap<String, String>();
    punch.put("Orange Juice", "2 cups");
    punch.put("Lime Juice", "1/2 cup");
    punch.put("Fruit Juice", "1 cup");
    punch.put("Strawberries", "20");
    punch.put("Mint leaves", "3");
    punch.put("Sprite", "2 cups");
    punch.put("Rum","1/2 bottle"); // <-- Uncomment Line to solve
    Approvals.verify(punch);
  }

  @Test
  public void headersHelpExplainTheContextWhenThingsAreConfusing() throws Exception
  {
    String header = "Numbers in the Fibonacci sequence";
    Integer[] values = {1, 2, 6, 9, 11};
    Approvals.verifyAll(header, values, new Sequence());
  }

  @Test
  public void transformingArraysManually() throws Exception
  {
    int[] numbers = {1, 3, 5, 10, 12, 16};
    StringBuffer b = new StringBuffer();
    for (int i : numbers)
    {
      b.append(String.format("%s^2 = %s\n", i, i * i));
    }
    Approvals.verify(b);
  }

  @Test
  public void transformingArraysWithFunctions() throws Exception
  {
    Integer[] numbers = {1, 3, 5, 10, 12, 16};
    Approvals.verifyAll("Squares", numbers, new Function1<Integer, String>()
    {
      @Override
      public String call(Integer i)
      {
        return String.format("%s^2 = %s", i, i * i);
      }
    });
  }

  @Test
  public void transformingArraysWithLambdas() throws Exception
  {
    // This requires java8
    Integer[] numbers = {1, 3, 5, 10, 12, 16};
    Approvals.verifyAll("Squares", numbers, n -> String.format("%s^2 = %s", n, n * n));
  }
}
