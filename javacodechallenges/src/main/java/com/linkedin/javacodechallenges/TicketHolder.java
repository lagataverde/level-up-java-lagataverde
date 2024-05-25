package com.linkedin.javacodechallenges;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

import org.apache.commons.csv.CSVRecord;

@Getter
@Setter
public class TicketHolder {

  private String name;
  private Integer ticketQuantity;

  public TicketHolder(String name, Integer ticketQuantity) {
    this.name = name;
    this.ticketQuantity = ticketQuantity;
  }

  public TicketHolder(CSVRecord csvRecord) {
    this.name = Objects.requireNonNull(csvRecord.get("Name:"));
    this.ticketQuantity = Integer.valueOf(Objects.requireNonNull(csvRecord.get("Quantity:")));
  }
}
