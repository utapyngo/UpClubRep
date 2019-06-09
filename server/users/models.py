from django.contrib.auth.models import AbstractBaseUser
from django.contrib.auth.models import PermissionsMixin
from django.db import models
from django.templatetags.static import static
from django.utils import timezone
from django.utils.functional import cached_property
from django.utils.translation import gettext_lazy as _
from django_extensions.db.models import TimeStampedModel
from phonenumber_field.modelfields import PhoneNumberField

from skills.models import Skill
from users.managers import UserManager
from users.templatetags.users_tags import photo_thumbnail


class User(AbstractBaseUser, PermissionsMixin):
    birth_date = models.DateField(blank=True, null=True)
    first_name = models.CharField(_('first name'), max_length=30, blank=True)
    middle_name = models.CharField(_('middle name'), max_length=150, blank=True)
    last_name = models.CharField(_('last name'), max_length=150, blank=True)
    phone_number = PhoneNumberField(unique=True)
    photo = models.ImageField(
        upload_to='user_photos',
        verbose_name=_('Upload a photo'),
        default='',
        blank=True,
    )
    email = models.EmailField(_('email address'), unique=True, blank=True)
    is_staff = models.BooleanField(
        _('staff status'), default=False,
        help_text=_('Designates whether the user can log into this admin '
                    'site.')
    )
    is_active = models.BooleanField(
        _('active'), default=True,
        help_text=_('Designates whether this user should be treated as '
                    'active. Unselect this instead of deleting accounts.')
    )
    date_joined = models.DateTimeField(_('date joined'), default=timezone.now)

    USERNAME_FIELD = 'phone_number'
    REQUIRED_FIELDS = []

    objects = UserManager()

    class Meta:
        verbose_name = _('user')
        verbose_name_plural = _('users')

    def __str__(self):
        return str(self.phone_number)

    @property
    def username(self):
        return self.phone_number

    @username.setter
    def username(self, value):
        pass

    def get_short_name(self):
        return self.first_name

    def get_full_name(self):
        full_name = '%s %s %s' % (self.first_name, self.middle_name, self.last_name)
        return full_name.strip().replace('  ', ' ')

    @cached_property
    def photo_url(self):
        try:
            return photo_thumbnail(self, 250)
        except FileNotFoundError:
            return static('img/userpic.svg')
