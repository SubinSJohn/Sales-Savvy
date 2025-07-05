package sales.savvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sales.savvy.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	
	List<CartItem> findByCartId(Long cartId);
    void deleteByCartId(Long cartId);

}
