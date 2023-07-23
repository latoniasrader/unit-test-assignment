

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumberAreCorrectly(int a, int b, int expected, boolean expectException) {


		if (!expectException) {

			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
            .isInstanceOf(IllegalArgumentException.class);
		
		}	
	}

	static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return (Stream.of(
				arguments(2, 4, 6, false),
				arguments(17, 27, 44, false),
				arguments(8, 18, 26, false)
				//arguments(-17, 7, -24, true)
				));
		//@formatter:on	
	}

	@Test
	void assertThatPairsOfPositiveNumberAreAddedCorrectly() {

		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(2, 4)).isEqualTo(6);
		assertThat(testDemo.addPositive(17, 27)).isEqualTo(44);
		assertThat(testDemo.addPositive(8, 18)).isEqualTo(26);
		//assertThat(testDemo.addPositive(-17, 7)).isEqualTo(-24);

	}
	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForGroceryBudget")
	void assertThatWeeklySpendingIsNotOverGroceryBudget(double perWeek, double overBudget, double expected, boolean expectException) {
		
		
		if(!expectException) {
			
			assertThat(testDemo.groceryBudget(perWeek, overBudget)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.groceryBudget(perWeek, overBudget))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}	
		
		static Stream<Arguments> argumentsForGroceryBudget() {
			//@formatter:off
			return (Stream.of(
					arguments(250.0, 250.0, 250.0, false),
					arguments(195.5, 195.5, 195.5, false),
					arguments(225.0, 225.0, 225.0, false),
					arguments(235.5, 235.5, 235.5, false)
					//arguments(355.9, 355.9, 250.0, true)
					));
			//@formatter:on	
		}
		
		@Test
		void assertThatWeeklySpendingIsNotOverGroceryBudget() {
			
			assertThat(testDemo.groceryBudget(250.0, 250.0)).isEqualTo(250.0);
			assertThat(testDemo.groceryBudget(195.5, 195.5)).isEqualTo(195.5);
			assertThat(testDemo.groceryBudget(225.0, 225.0)).isEqualTo(225.0);
			assertThat(testDemo.groceryBudget(235.5, 235.5)).isEqualTo(235.5);
			//assertThat(testDemo.groceryBudget(355.9, 335.9)).isEqualTo(250.0);
	
	}
		@Test
		void assertThatNumberSquaredIsCorrect() {
			
			TestDemo mockDemo = spy(testDemo);
			
			doReturn(5).when(mockDemo).getRandomint();
			int fiveSquared = mockDemo.randomNumberSquared();
			assertThat(fiveSquared).isEqualTo(25);
		}

}
