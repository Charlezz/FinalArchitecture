package com.charlezz.finalarchitecture.di.annotation

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Named(val value: String = "")