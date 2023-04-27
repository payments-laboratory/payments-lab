package org.collaborators.paymentslab.account.domain.exception

import org.collaborator.paymentlab.common.error.ErrorCode
import org.collaborator.paymentlab.common.error.ServiceException

class InvalidAccountException: ServiceException(ErrorCode.INVALID_ACCOUNT)