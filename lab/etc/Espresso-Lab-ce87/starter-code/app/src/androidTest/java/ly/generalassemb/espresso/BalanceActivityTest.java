package ly.generalassemb.espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//import static android.support.test.espresso.matcher.ViewMatchers.onData;

/**
 * Created by owlslubic on 7/21/16.
 */
@RunWith(AndroidJUnit4.class)
public class BalanceActivityTest {

    @Rule
    public ActivityTestRule<BalanceActivity> mBalanceTestRule =
            new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Test
    public void canViewCurrentBalanceTest() throws Exception{
        onView(withId(R.id.balanceTextView))
                .check(matches(isDisplayed()));
    }
    @Test
    public void canWithdrawMoneyTest() throws Exception{
        String description = "Tuition";
        String value = "25";
        String expectedAnswer = "-$25.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(typeText(value));
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedAnswer)));
    }
    @Test
    public void canDepositMoneyTest() throws Exception{
        String description = "Tuition";
        String value = "25";
        String expectedAnswer = "$25.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedAnswer)));
    }
    @Test
    public void multipleTransactionsTest() throws Exception{
        String description = "Tuition";
        String value = "25";
        String expectedAnswer = "$25.00";

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(typeText(value));
        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(value));
        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton))
                .perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(clearText(),typeText(description));
        onView(withId(R.id.amountEditText))
                .perform(clearText(),typeText(value));
        onView(withId(R.id.depositButton))
                .perform(click());

        onView(withId(R.id.balanceTextView))
                .check(matches(withText(expectedAnswer)));
    }
//    @Test
//    public void seeListOfTransactionsTest() throws Exception{
//        onView(withId(R.id.transactionsListView))
//                .check(matches(isDisplayed()));
//    }

    //i was gonna try the bonus but it's more complicated than expected
//    @Test
//    public void transactionListItemValueIsCorrect() throws Exception{
//        String description = "Tuition";
//        String value = "25";
//        String expectedAnswer = "$25.00";
//
//        onView(withId(R.id.newTransactionButton))
//                .perform(click());
//        onView(withId(R.id.descriptionEditText))
//                .perform(typeText(description));
//        onView(withId(R.id.amountEditText))
//                .perform(typeText(value));
//        onView(withId(R.id.depositButton))
//                .perform(click());
//        onView(withId(R.id.balance_item_amount))
//                .check(matches(withText(expectedAnswer)));
//        onView(withId(R.id.balance_item_description))
//                .check(matches(withText(description)));

     //   onData(allOf(is(instanceOf(Transaction.class))), withmDescription.check(matches(withText(description)));
    }




