package fiap.tech.challenge.application.adapter.outbound.repository.pedido;

import fiap.tech.challenge.application.core.entity.pedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}