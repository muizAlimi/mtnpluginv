package com.fbn.mtoplugin.exceptions

class SendWaveTransactionNotFound(message : String) : RuntimeException(message)
class ApiErrorException(message : String) : RuntimeException(message)
class FlutterWaveTransactionNotFound(message : String) : RuntimeException(message)
class FuntechTransactionNotFound(message : String) : RuntimeException(message)