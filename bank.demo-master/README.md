# bank.demo
							REST API   
========================== CLIENT      ==========================   
http://localhost:8080/client/all                                             
http://localhost:8080/client/add
http://localhost:8080/client/firstname/{firstname}
http://localhost:8080/client/lastname/{lastname}
http://localhost:8080/client/idnp/{idnp}
http://localhost:8080/client/id/{id}  @get
http://localhost:8080/client/id/{id}	@del
http://localhost:8080/client/update   ????
========================== BANK 	   ========================== 
http://localhost:8080/bank/all
http://localhost:8080/bank/add
http://localhost:8080/bank/name/{name}
http://localhost:8080/bank/address/{address}
http://localhost:8080/bank/id/{id} @get
http://localhost:8080/bank/id/{id} @del
http://localhost:8080/bank/update
http://localhost:8080/bank/send/branch/1 // trimite bani catre filila idBank
http://localhost:8080/bank/receive/branch/1 // primeste bani inapoi de la filiala idBank
========================== BANKBRANCH  ==========================
http://localhost:8080/bankbranche/all
http://localhost:8080/bankbranche/add
http://localhost:8080/bankbranche/branchename/{branchename}
http://localhost:8080/bankbranche/address/{brancheAddress}
http://localhost:8080/bankbranche/id/{id} @get
http://localhost:8080/bankbranche/id/{id}  @del
http://localhost:8080/bankbranche/update
http://localhost:8080/bankbranche/change/money/2/EUR/1/1  - change money
http://localhost:8080/bankbranche/send/money/sc_1/sb_1/se_1/rc_3 - send money
http://localhost:8080/bankbranche/receive/money/rc_3/rb_2/re_2/tr_1 - receive money
========================== CURRENCY    ==========================
http://localhost:8080/exchange/currency/add
http://localhost:8080/exchange/currency/all
http://localhost:8080/exchange/currency/id/2  @get
http://localhost:8080/exchange/currency/id/2  @delete

========================== EMPLOYEE    ==========================
http://localhost:8080/employees/all
http://localhost:8080/employees/add

=================================================================
