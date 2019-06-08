from django.template import Library
from django.templatetags.static import static
from django.utils.safestring import mark_safe
from easy_thumbnails.exceptions import EasyThumbnailsError
from easy_thumbnails.files import get_thumbnailer

register = Library()


@register.filter
def photo_thumbnail(user, size):
    try:
        photo_link = get_thumbnailer(user.photo)[str(size)].url
    except (EasyThumbnailsError, ValueError):
        photo_link = static('img/userpic.svg')
    return mark_safe(photo_link)
