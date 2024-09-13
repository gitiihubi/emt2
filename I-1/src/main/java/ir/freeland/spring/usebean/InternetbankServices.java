package ir.freeland.spring.usebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InternetbankServices {
  @Autowired
  private CardServices cardService;
  @Autowired
  private DatabaseManagment database;

  public void doCardToCard(String sourceCard, String destinationCard) {

    // CardServices cardService = new CardServices();
    // DatabaseManagment database = new DatabaseManagment();

    String result = cardService.cardToCard(sourceCard, destinationCard);
    database.save(result);

  }
}
