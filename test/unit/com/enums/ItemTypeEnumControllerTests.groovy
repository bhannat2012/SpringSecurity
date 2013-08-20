package com.enums



import org.junit.*
import grails.test.mixin.*

@TestFor(ItemTypeEnumController)
@Mock(ItemTypeEnum)
class ItemTypeEnumControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/itemTypeEnum/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.itemTypeEnumInstanceList.size() == 0
        assert model.itemTypeEnumInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.itemTypeEnumInstance != null
    }

    void testSave() {
        controller.save()

        assert model.itemTypeEnumInstance != null
        assert view == '/itemTypeEnum/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/itemTypeEnum/show/1'
        assert controller.flash.message != null
        assert ItemTypeEnum.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/itemTypeEnum/list'

        populateValidParams(params)
        def itemTypeEnum = new ItemTypeEnum(params)

        assert itemTypeEnum.save() != null

        params.id = itemTypeEnum.id

        def model = controller.show()

        assert model.itemTypeEnumInstance == itemTypeEnum
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/itemTypeEnum/list'

        populateValidParams(params)
        def itemTypeEnum = new ItemTypeEnum(params)

        assert itemTypeEnum.save() != null

        params.id = itemTypeEnum.id

        def model = controller.edit()

        assert model.itemTypeEnumInstance == itemTypeEnum
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/itemTypeEnum/list'

        response.reset()

        populateValidParams(params)
        def itemTypeEnum = new ItemTypeEnum(params)

        assert itemTypeEnum.save() != null

        // test invalid parameters in update
        params.id = itemTypeEnum.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/itemTypeEnum/edit"
        assert model.itemTypeEnumInstance != null

        itemTypeEnum.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/itemTypeEnum/show/$itemTypeEnum.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        itemTypeEnum.clearErrors()

        populateValidParams(params)
        params.id = itemTypeEnum.id
        params.version = -1
        controller.update()

        assert view == "/itemTypeEnum/edit"
        assert model.itemTypeEnumInstance != null
        assert model.itemTypeEnumInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/itemTypeEnum/list'

        response.reset()

        populateValidParams(params)
        def itemTypeEnum = new ItemTypeEnum(params)

        assert itemTypeEnum.save() != null
        assert ItemTypeEnum.count() == 1

        params.id = itemTypeEnum.id

        controller.delete()

        assert ItemTypeEnum.count() == 0
        assert ItemTypeEnum.get(itemTypeEnum.id) == null
        assert response.redirectedUrl == '/itemTypeEnum/list'
    }
}
