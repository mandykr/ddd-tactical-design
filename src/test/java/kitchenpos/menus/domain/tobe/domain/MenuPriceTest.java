package kitchenpos.menus.domain.tobe.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuPriceTest {
    @DisplayName("0이상의 정수로 메뉴 가격을 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    void create(BigDecimal price) {
        assertThatCode(() -> new MenuPrice(price))
                .doesNotThrowAnyException();
    }

    @DisplayName("메뉴 가격은 0이상의 정수 이어야 한다")
    @ParameterizedTest
    @ValueSource(strings = "-1")
    @NullSource
    void createInvalidPrice(BigDecimal price) {
        assertThatThrownBy(() -> new MenuPrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가격은 0이상의 정수 이어야 합니다. 입력 값 : " + price);
    }
}
