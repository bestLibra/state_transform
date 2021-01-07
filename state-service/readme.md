### 描述下com.tansen.study.service.event包下的结构

- 最外层的AfterSaleEventEnum、SaleOrderEventEnum是售后单和销售单的对应事件
- driver是驱动者，负责携带情报(当前订单、个性化参数、下一步事件等)，根据当前状态找到对应的行动队长
- action是行动队长，负责根据事件去执行



