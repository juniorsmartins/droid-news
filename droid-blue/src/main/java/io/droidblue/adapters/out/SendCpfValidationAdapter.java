package io.droidblue.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import io.droidblue.application.ports.out.SendCpfForValidationOutputPort;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void send(String cpf) {

    kafkaTemplate.send("topico-cpf-validation", cpf);
  }  
}

