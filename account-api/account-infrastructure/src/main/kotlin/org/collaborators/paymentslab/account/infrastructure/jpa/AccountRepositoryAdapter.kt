package org.collaborators.paymentslab.account.infrastructure.jpa

import org.collaborator.paymentlab.common.error.ErrorCode
import org.collaborator.paymentlab.common.error.ResourceNotFoundException
import org.collaborator.paymentlabs.account.domain.Account
import org.collaborator.paymentlabs.account.domain.AccountRepository

class AccountRepositoryAdapter(
    private val jpaAccountRepository: JpaAccountRepository
): AccountRepository {
    override fun existByEmail(email: String): Boolean {
        return jpaAccountRepository.existsByEmail(email)
    }

    override fun save(account: Account): Account {
        return jpaAccountRepository.save(account)
    }

    override fun findByEmail(email: String): Account {
        return jpaAccountRepository.findByEmail(email) ?: throw ResourceNotFoundException(ErrorCode.ACCOUNT_NOT_FOUND)
    }

    override fun findById(accountId: String): Account {
        return jpaAccountRepository.findByAccountKey(accountId) ?: throw ResourceNotFoundException(ErrorCode.ACCOUNT_NOT_FOUND)
    }

    override fun existByUsername(username: String): Boolean {
        return jpaAccountRepository.existsByUsername(username)
    }
}